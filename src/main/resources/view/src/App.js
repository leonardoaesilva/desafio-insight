import './App.css';
import { useState } from 'react';
import Form from './Form';
import Tabela from './Tabela';

function App() {
  
  const[btnCadastrar, setBtnCadastrar] = useState(true);
  return (
    <div>
      <Form acao={btnCadastrar} />
      <Tabela />
    </div>
  );
}

export default App;
