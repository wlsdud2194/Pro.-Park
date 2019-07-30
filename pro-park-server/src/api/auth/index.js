const router = require('express').Router();
const authCtrl = require('./auth.ctrl');

router.route('/login').post(authCtrl.login);
router.route('/signup').post(authCtrl.signup);
router.route('/checkid').post(authCtrl.checkId);
router.route('/prove').post(authCtrl.proveEmail);

module.exports = router;
