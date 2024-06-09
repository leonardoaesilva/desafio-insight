import './App.css';
import { useEffect, useState } from 'react';
import Form from './Form';
import Tabela from './Tabela';

function App() {
  
  const fornecedor = { codigoFornecedor:0, nome:'', cnpj:'' }

  const[btnCadastrar, setBtnCadastrar] = useState(true);
  const[fornecedores, setFornecedor] = useState([]);
  const[objFornecedor, setObjFornecedor] = useState(fornecedor);

  useEffect(() => { fetch("http://localhost:8080/api/fornecedores").then(resp => resp.json()).then(jsonResp => setFornecedor(jsonResp)); }, []);

  return (
    <div>
      <Form acao={btnCadastrar} />
      <p>{JSON.stringify(objFornecedor)}</p>
      <Tabela lista={fornecedores} />
    </div>
  );
}

export default App;
