// IMPORTS
const express = require('express');
const router = express.Router();
const User = require('../model/User');


// ROTAS

/* GET users listing. */
router.get("/", async function(req, res) {
  return  res.json(await User.find());
});

// Obter um usuário pelo ID
router.get("/:id", async (req, res) => {
  const {id} = req.params;

  const result = await User.findById(id);
  return result 
    ? res.json(result)
    : res.status(404).send();
});

// Criar uma pessoa
router.post("/", async (req, res) => {
  const json = req.body;

  const user = new User(json);

  const hasErrors = user.validateSync();

  return hasErrors
    ? res.status(400).json(hasErrors)
    : res.status(201).json(await user.save());
});




// EXPORT DO MÓDULO
module.exports = router;
