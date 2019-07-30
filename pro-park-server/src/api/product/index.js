const router = require('express').Router();
const productCtrl = require('./product.ctrl');

router.route('/:barcode').get(productCtrl.getProductPage);
router.route('/').get(productCtrl.getProductList);
router.route('/').post(productCtrl.createProduct);

module.exports = router;
