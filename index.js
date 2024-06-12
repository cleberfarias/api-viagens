// Importando as dependências
const express = require('express');
const app = express();
const port = 3000;

// Configurando o body-parser e o CORS
app.use(express.json());
let tasks = [];

// Rota padrão
app.get('/task', (req, res) => {
  res.json(tasks);
});

// Método para salvar uma nova tarefa
app.post('/task', (req, res) => {
  const newTask = req.body;
  tasks.push(newTask);
  res.status(201).json(newTask);
});

// Método para alterar uma tarefa existente
app.put('/task/:id', (req, res) => {
  const id = req.params.id;
  const updatedTask = req.body;
  tasks = tasks.map(task =>{
    if(task.id ==id){
        return {...task, nome: updatedTask.nome}
    }
    return task;
  })
  res.json(updatedTask);
});

// Método para excluir uma tarefa
app.delete('/task/:id', (req, res) => {
  const id = req.params.id;
  tasks.splice(id, 1);
  res.sendStatus(204);
});

// Definindo a porta em que o servidor vai escutar
const PORT = process.env.PORT || 3000;

// Iniciando o servidor
app.listen(PORT, () => {
  console.log(`Servidor rodando na porta ${PORT}`);
});
