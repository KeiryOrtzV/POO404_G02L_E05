document.addEventListener('DOMContentLoaded', function() {
    // Cerrar el modal al hacer clic en el botón de cerrar
    const closeModalButton = document.querySelector('.btn-close');
    closeModalButton.addEventListener('click', function() {
        const modal = document.getElementById('exampleModal');
        modal.classList.remove('show');
        modal.style.display = 'none';
    });

    // Cerrar el modal al hacer clic fuera de él
    window.addEventListener('click', function(event) {
        const modal = document.getElementById('exampleModal');
        if (event.target === modal) {
            modal.classList.remove('show');
            modal.style.display = 'none';
        }
    });
});
