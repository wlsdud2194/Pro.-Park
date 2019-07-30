const models = require('../../models');

// 댓글 작성
exports.createComment = async (req, res) => {
  const { memberId } = req.decoded;
  const { body } = req; // content, product_barcode

  try {
    const comment = await models.Post.createPost(memberId, body);

    if (!comment) {
      console.error('[comment - createComment] 뭔가 잘못됬습니다');
      const result = {
        status: 400,
        message: '댓글 작성 실패'
      };
  
      res.status(400).json(result);
      return;
    }

    const result = {
      status: 200,
      message: '댓글 작성 성공'
    }

    res.status(200).json(result);

    console.log('[comment - createComment] 댓글 작성 성공');
  } catch (error) {
    console.error(`[comment - createComment] 서버 에러 : ${error}`);
    const result = {
      status: 500,
      message: '댓글 작성 실패'
    };

    res.status(500).json(result);
  }
};

// 대댓글 작성
exports.createReComment = async (req, res) => {
  const { decoded: { memberId }, body } = req;
  // body : content, postIdx
  
  try {
    const recomment = await models.Comment.createComment(memberId, body);
    
    if (!recomment) {
      console.error('[comment - createRecomment] 뭔가 잘못됬습니다');
      const result = {
        status: 400,
        message: '대댓글 작성 실패',
      };
  
      res.status(400).json(result);
      return;
    }

    const result = {
      status: 200,
      message: '대댓글 작성 성공',
    }

    res.status(200).json(result);

    console.log('[comment - createRecomment] 대댓글 작성 성공');
  } catch (error) {
    console.error(`[comment - createRecomment] 서버 에러 : ${error}`);
    const result = {
      status: 500,
      message: '대댓글 작성 실패',
    };

    res.status(500).json(result);
  }
}

// 좋아요 토글
exports.toggleLike = async (req, res) => {
  const { decoded: { memberId }, body } = req;
  // body : postIdx
  try {
    const postFeeds = await models.PostFeedback.getFeedById(memberId, body.postIdx);
    console.log(postFeeds);
    if (Array.isArray(postFeeds)) {
      if (postFeeds.length > 0) {
        console.log('취소');
        await models.PostFeedback.deleteLike(memberId, body.postIdx);
      } else {
        console.log('추천');
        await models.PostFeedback.createLike(memberId, body.postIdx);
      }
    }

    const result = {
      status: 200,
      message: '추천 토글 성공',
    };

    res.status(200).json(result);

    console.log('[comment - toggleLike] 추천 토글 성공');
  } catch (error) {
    console.error(`[comment - toggleLike] 서버 에러 : ${error}`);
    const result = {
      status: 500,
      message: '추천 토글 실패',
    };

    res.status(500).json(result);
  }
};

// 글 삭제
exports.deleteComment = async (req, res) => {
  // const {  } = req;
};

