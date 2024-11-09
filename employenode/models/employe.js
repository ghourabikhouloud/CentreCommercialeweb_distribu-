const mongoose = require('mongoose');

const employeSchema = new mongoose.Schema({
  nom: String,
  prenom: String,
  idBoutique: mongoose.Schema.Types.ObjectId,
});

const employe = mongoose.model('employe', employeSchema);

module.exports = employe;
