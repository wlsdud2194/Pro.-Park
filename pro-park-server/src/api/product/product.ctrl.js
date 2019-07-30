const models = require('../../models');
const { asyncForeach } = require('../../lib/method');

/**
 * @description 특정 제품과 관련하여 정보를 보내줌
 */
exports.getProductPage = async (req, res) => {
  const { memberId, name } = req.decoded;
  const { barcode } = req.params;

  try {
    // 제품 조회
    const product = await models.Product.getProductByBarcode(barcode);

    // 제품에 대한 댓글 조회
    // let posts = await models.Post.getPostByBarcode(models, barcode);
    let posts = await models.Post.getPostByBarcode(barcode);


    if (posts) {
      for (post of posts) {
        // 제품에 대한 대댓글 조회
        const comments = await models.Comment.getCommentByPostIdx(post.idx);
        const likeCount = await models.PostFeedback.getFeedByPostIdx(post.idx);
        let like = 0;

        for (likeUser of likeCount) {
          console.log(likeUser.memberId);
          if (memberId === likeUser.memberId) {
            like = 1;
          }
        }

        post.like = like;
        post.likeCount = likeCount.length;
        post.recomment = comments;
      }

      posts.sort((a, b) => { // 내림차순
        return b['likeCount'] - a['likeCount'];
        // 44, 25, 21, 13
    });
    }
    console.log(posts);

    const result = {
      status: 200,
      message: '제품에 관한 정보및 댓글 조회',
      data: {
        ...product,
        comment: posts,
      },
    };

    res.status(200).json(result);

  } catch (error) {
    console.log(`[product - getProductPage] 서버에러 : ${error}`);
    const result = {
      status: 500,
      message: '특정 제품 목록조회 실패',
    };

    res.status(500).json(result);
  }
};

/**
 * @description 제품의 목록을 불러온다
 */
exports.getProductList = async (req, res) => {
  try {
    const product = await models.Product.getRecommendProduct();

    const result = {
      status: 200,
      message: '제품 목록조회 성공',
      data: {
        product,
      }
    };

    res.status(200).json(result);
    console.log('[product - getProductList] 제품 목록조회 성공');
  } catch (error) {
    console.log(`[product - getProductList] 서버에러 : ${error}`);
    const result = {
      status: 500,
      message: '제품 목록조회 실패',
    };

    res.status(500).json(result);
  }
};

/**
 * @description 제품을 등록한다
 */
exports.createProduct = async (req, res) => {
  const { body } = req;

  console.log('[product - createProduct] 제품등록 바디 ', body);

  try {
    const product = await models.Product.create(body);

    if (!product) {
      console.error('[product - createProduct] 제품 등록 실패');
      const result = {
        status: 400,
        message: '제품 생성에 실패했습니다',
      };

      res.status(400).json(result);
      return;
    }

    const result = {
      status: 200,
      message: '제품 등록에 성공하였습니다',
    };

    res.status(200).json(result);
    console.log('[product - createProduct] 제품 등록됨');
  } catch (error) {
    console.error(`[product - createProduct] 서버에러 : ${error}`);
    const result = {
      status: 500,
      message: '제품 등록 실패',
    };

    res.status(500).json(result);
  }
};
