import './App.css';
import { useEffect, useState } from 'react';
import Form from './Form';
import Tabela from './Tabela';

function App() {
  const[btnCadastrar, setBtnCadastrar] = useState(true);
  const[fornecedores, setFornecedor] = useState([]);

  useEffect(() => { fetch("http://localhost:8080/api/fornecedores").then(resp => resp.json()).then(jsonResp => setFornecedor(jsonResp)); }, []);

  return (
    <div>
      <Form acao={btnCadastrar} />
      <Tabela />
      <div>
        <p>{JSON.stringify(fornecedores)}</p>
      </div>
    </div>
  );
}

export default App;
