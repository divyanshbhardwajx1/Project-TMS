// Form validation script
document.addEventListener("DOMContentLoaded", () => {
    // Login Form Validation
    const loginForm = document.querySelector("#loginForm");
    if (loginForm) {
        loginForm.addEventListener("submit", (event) => {
            event.preventDefault();
            if (validateLoginForm()) {
                loginForm.submit(); // Submit form if valid
            }
        });
    }

    // Registration Form Validation
    const registerForm = document.querySelector("#registerForm");
    if (registerForm) {
        registerForm.addEventListener("submit", (event) => {
            event.preventDefault();
            if (validateRegisterForm()) {
                registerForm.submit(); // Submit form if valid
            }
        });

        // Real-time password strength check
        const passwordInput = registerForm.querySelector("#password");
        const strengthMessage = registerForm.querySelector("#passwordStrength");
        if (passwordInput && strengthMessage) {
            passwordInput.addEventListener("input", () => {
                const strength = checkPasswordStrength(passwordInput.value);
                strengthMessage.textContent = strength.message;
                strengthMessage.style.color = strength.color;
            });
        }
    }
});

// Validate Login Form
function validateLoginForm() {
    const email = document.querySelector("#email");
    const password = document.querySelector("#password");
    let isValid = true;

    clearErrors();

    if (!validateEmail(email.value)) {
        showError(email, "Please enter a valid email address.");
        isValid = false;
    }

    if (password.value.trim() === "") {
        showError(password, "Password is required.");
        isValid = false;
    }

    return isValid;
}

// Validate Registration Form
function validateRegisterForm() {
    const fullName = document.querySelector("#full-name");
    const email = document.querySelector("#email");
    const password = document.querySelector("#password");
    const confirmPassword = document.querySelector("#confirm-password");
    let isValid = true;

    clearErrors();

    if (fullName.value.trim() === "") {
        showError(fullName, "Full name is required.");
        isValid = false;
    }

    if (!validateEmail(email.value)) {
        showError(email, "Please enter a valid email address.");
        isValid = false;
    }

    if (password.value.trim() === "") {
        showError(password, "Password is required.");
        isValid = false;
    } else if (!checkPasswordStrength(password.value).isStrong) {
        showError(password, "Password must be at least 8 characters and include a number and a special character.");
        isValid = false;
    }

    if (password.value !== confirmPassword.value) {
        showError(confirmPassword, "Passwords do not match.");
        isValid = false;
    }

    return isValid;
}

// Utility Functions
function validateEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

function checkPasswordStrength(password) {
    const strongRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    if (strongRegex.test(password)) {
        return { isStrong: true, message: "Strong password.", color: "green" };
    } else {
        return { isStrong: false, message: "Weak password.", color: "red" };
    }
}

function showError(input, message) {
    const parent = input.closest(".mb-3");
    const error = document.createElement("div");
    error.className = "text-danger mt-1";
    error.textContent = message;
    parent.appendChild(error);
    input.classList.add("is-invalid");
}

function clearErrors() {
    const errors = document.querySelectorAll(".text-danger");
    errors.forEach((error) => error.remove());
    const inputs = document.querySelectorAll(".is-invalid");
    inputs.forEach((input) => input.classList.remove("is-invalid"));
}
