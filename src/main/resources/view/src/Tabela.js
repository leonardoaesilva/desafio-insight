function Tabela({lista}) {
    return(
        <table className='table'>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>CNPJ</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                {
                    lista.map((obj, i) => (
                        <tr key={i}>
                            <td>{i+1}</td>
                            <td>{obj.nome}</td>
                            <td>{obj.cnpj}</td>
                            <td><button className="btn btn-info">(+)</button></td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    )
}

export default Tabela;