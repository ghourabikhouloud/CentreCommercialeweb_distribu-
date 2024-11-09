const express = require('express');
const router = express.Router();
const employeController = require('../controllers/employeController');

// Routes pour les produits
router.get('/', employeController.getAllemployees);
router.get('/:id', employeController.getemployeById);
router.post('/', employeController.createemploye);
router.put('/:id', employeController.updateemploye);
router.delete('/:id', employeController.deleteemploye);

module.exports = router;
