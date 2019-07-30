module.exports = (sequelize, DataTypes) => {
  const Comment  = sequelize.define('Comment', {
    idx: {
      field: 'idx',
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    content: {
      field: 'content',
      type: DataTypes.STRING(1000),
      allowNull: false,
    },
    writeDate: {
      field: 'write_date',
      type: DataTypes.DATE,
      allowNull: false,
      defaultValue: sequelize.NOW,
    },
    writerId: {
      field: 'writer_id',
      type: DataTypes.STRING(40),
      allowNull: false,
    },
    postIdx: {
      field: 'post_idx',
      type: DataTypes.INTEGER,
      allowNull: false,
    },
  }, {
    tableName: 'comment',
    timestamps: false,
  });

  Comment.associate = (models) => {
    Comment.belongsTo(models.Member, {
      foreignKey: 'writer_id',
    });
    Comment.belongsTo(models.Post, {
      foreignKey: 'post_idx',
    });
  };

  Comment.getCommentByPostIdx = (postIdx) => Comment.findAll({
    attributes: ['idx', 'content', 'writerId', 'writeDate'],
    where: {
      postIdx,
    },
    order: [['write_date', 'desc']],
    raw: true,
  });

  Comment.createComment = (memberId, data) => Comment.create({
    writerId: memberId,
    content: data.content,
    postIdx: data.postIdx,
  });

  return Comment;
};
