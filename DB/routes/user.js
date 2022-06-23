var express = require('express');
var multer = require('../controller/multer');
var router = express.Router();
const userFunction = require('../controller/user');

router.post('/', userFunction.addUser);

router.put('/updateProfile', multer, userFunction.replaceData);

router.get('/', userFunction.showUser);

router.get('/:id', userFunction.showUserByID);

router.delete('/:id', userFunction.deleteUser);

router.post('/login', userFunction.login);

router.post('/check', userFunction.checkEmail);

router.post('/reset', userFunction.updatePassword);

router.post('/userImage', userFunction.uploadUserImage);

module.exports = router;
