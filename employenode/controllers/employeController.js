const employee = require('../models/employe');

module.exports = {
  // Récupérer tous les produits
  async getAllemployees(req, res) {
    try {
      const employees = await employee.find();
      res.json(employees);
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  },

  // Récupérer un produit par son ID
  async getemployeById(req, res) {
    try {
      const employe = await employee.findById(req.params.id);
      if (employe === null) {
        return res.status(404).json({ message: 'employe non trouvé' });
      }
      res.json(employe);
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  },

  // Créer un produit
  async createemploye(req, res) {
    const employe = new employee(req.body);
    try {
      const newemploye = await employe.save();
      res.status(201).json(newemploye);
    } catch (err) {
      res.status(400).json({ message: err.message });
    }
  },

  // Mettre à jour un produit
  async updateemploye(req, res) {
    try {
      const employe = await employee.findByIdAndUpdate(req.params.id, req.body, { new: true });
      if (employe === null) {
        return res.status(404).json({ message: 'employe non trouvé' });
      }
      res.json(employe);
    } catch (err) {
      res.status(400).json({ message: err.message });
    }
  },

  // Supprimer un produit
  async deleteemploye(req, res) {
    try {
      const employe = await employee.findByIdAndDelete(req.params.id);
      if (employe === null) {
        return res.status(404).json({ message: 'employe non trouvé' });
      }
      res.json({ message: 'employe supprimé avec succès' });
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  }
};
