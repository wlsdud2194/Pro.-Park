const router = require('express').Router();
const commentCtrl = require('./comment.ctrl');

router.route('/').post(commentCtrl.createComment);
router.route('/').delete(commentCtrl.deleteComment);
router.route('/recomment').post(commentCtrl.createReComment);
router.route('/toggle').post(commentCtrl.toggleLike);

module.exports = router;
