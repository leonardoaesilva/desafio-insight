function Form() {
    return(
        <form>
            <input type='text' placeholder='Nome' />
            <input type='text' placeholder='CNPJ' />

            <input type='button' value='Cadastrar' />
            <input type='button' value='Editar' />
            <input type='button' value='Remover' />
            <input type='button' value='Cancelar' />
        </form>
    )
}

export default Form;