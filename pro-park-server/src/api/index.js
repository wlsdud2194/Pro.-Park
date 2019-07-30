const api = require('express').Router();

const authMiddleware = require('../middleware/auth');

const auth = require('./auth');
const product = require('./product');
const comment = require('./comment');

api.use('/auth', auth);
api.use('/product', authMiddleware, product);
api.use('/comment', authMiddleware, comment);

module.exports = api;
