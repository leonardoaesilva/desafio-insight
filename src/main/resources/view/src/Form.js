function Form({acao}) {
    return(
        <form>
            <input type='text' placeholder='Nome' className='form-control' />
            <input type='text' placeholder='CNPJ' className='form-control' />

        {
            acao ? 
                <input type='button' value='Cadastrar' className='btn btn-success' /> :
                <div>
                    <input type='button' value='Cancelar' className='btn btn-secondary' />
                    <input type='button' value='Editar' className='btn btn-primary' />
                    <input type='button' value='Remover' className='btn btn-danger' />
                </div>
        }
        </form>
    )
}

export default Form;