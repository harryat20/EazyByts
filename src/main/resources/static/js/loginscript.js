const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');
const signupForm = document.getElementById('signupForm');
const loginForm = document.getElementById('loginForm');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});

loginForm.addEventListener('submit', (event) => {
    event.preventDefault();
    // Perform login logic here if needed
    loginForm.submit(); // Submit the form
});

signupForm.addEventListener('submit', (event) => {
    event.preventDefault();
    // Perform signup logic here if needed
    signupForm.submit(); // Submit the form
});