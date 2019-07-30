module.exports = (sequelize, DataTypes) => {
  const Post  = sequelize.define('Post', {
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
    productBarcode: {
      field: 'product_barcode',
      type: DataTypes.STRING(45),
      allowNull: false,
    },
    writerId: {
      field: 'writer_id',
      type: DataTypes.STRING(40),
      allowNull: false,
    },
  }, {
    tableName: 'post',
    timestamps: false,
  });

  Post.associate = (models) => {
    Post.hasMany(models.PostFeedback, {
      foreignKey: 'post_idx',
    });
    Post.hasMany(models.Comment, {
      foreignKey: 'post_idx',
    });

    Post.belongsTo(models.Member, {
      foreignKey: 'writer_id',
    });
    Post.belongsTo(models.Product, {
      foreignKey: 'product_barcode',
    });
  };

  Post.getPostByBarcode = (barcode) => Post.findAll({
    attributes: ['idx', 'content', 'writerId', 'writeDate'],
    where: {
      productBarcode: barcode,
    },
    raw: true,
  });

  // Post.getPostByBarcode = (models, barcode) => models.sequelize.query(`
  //   SELECT post.idx AS idx, post.content AS content, post.write_date AS writeDate, post.writer_id AS writerId, post.product_barcode AS barcode
  //   FROM post_feedback
  //   LEFT JOIN post
  //   ON post.idx = post_feedback.post_idx
  //   WHERE post_idx IN (
  //     SELECT idx
  //     FROM post 
  //     WHERE post.product_barcode = :barcode
  //   )
  //   GROUP BY post_idx
  //   ORDER BY count(post_idx) DESC
  // `, {
  //   type: sequelize.QueryTypes.SELECT,
  //   replacements: {
  //     barcode,
  //   }
  // });

  Post.createPost = (memberId, data) => Post.create({
    writerId: memberId,
    content: data.content,
    productBarcode: data.productBarcode,
    writeDate: new Date(),
  });

  return Post;
};
