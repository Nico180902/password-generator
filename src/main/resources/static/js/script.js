document.addEventListener('DOMContentLoaded', function() {
    const generateButton = document.getElementById('generateButton');
    const passwordDisplay = document.getElementById('passwordDisplay');
    const lengthSlider = document.getElementById('lengthSlider');
    const lengthDisplay = document.getElementById('lengthDisplay');

    lengthSlider.addEventListener('input', function() {
        lengthDisplay.textContent = lengthSlider.value;
    });

    generateButton.addEventListener('click', function() {
        const passwordLength = lengthSlider.value;
        fetch(`/generate?length=${passwordLength}`)
            .then(response => response.text())
            .then(password => {
                passwordDisplay.textContent = password;
                passwordDisplay.style.display = 'block';
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});
