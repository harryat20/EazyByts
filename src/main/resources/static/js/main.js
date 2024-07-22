document.addEventListener('DOMContentLoaded', () => {
    if (window.location.pathname.endsWith('stock.html')) {
        document.getElementById('stockSymbol').addEventListener('change', () => {
            const symbol = document.getElementById('stockSymbol').value;
            if (symbol) {
                fetchStock(symbol);
            }
        });
    }

    if (window.location.pathname.endsWith('portfolio.html')) {
        fetchPortfolio();
    }

    if (window.location.pathname.endsWith('transactions.html')) {
        fetchTransactions();
    }

    if (window.location.pathname.endsWith('login.html')) {
        document.getElementById('loginForm').addEventListener('submit', (event) => {
            event.preventDefault();
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            loginUser(email, password);
        });
    }
});
