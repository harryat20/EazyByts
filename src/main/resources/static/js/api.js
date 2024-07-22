const API_BASE_URL = 'http://localhost:8080'; // Replace with your API base URL

async function fetchStock(symbol) {
    try {
        const response = await fetch(`${API_BASE_URL}/stocks/${symbol}`);
        const data = await response.json();
        document.getElementById('stockDetails').innerHTML = `
            <p>Symbol: ${data.symbol}</p>
            <p>Price: $${data.price}</p>
            <p>Timestamp: ${data.timestamp}</p>
        `;
    } catch (error) {
        console.error('Error fetching stock data:', error);
    }
}

async function fetchPortfolio() {
    try {
        const response = await fetch(`${API_BASE_URL}/portfolio`);
        const data = await response.json();
        const portfolioDiv = document.getElementById('portfolio');
        portfolioDiv.innerHTML = '<h3>Stocks in Portfolio</h3>';
        data.forEach(stock => {
            portfolioDiv.innerHTML += `
                <p>${stock.symbol}: ${stock.quantity} units</p>
            `;
        });
    } catch (error) {
        console.error('Error fetching portfolio data:', error);
    }
}

async function fetchTransactions() {
    try {
        const response = await fetch(`${API_BASE_URL}/transactions`);
        const data = await response.json();
        const transactionsDiv = document.getElementById('transactions');
        transactionsDiv.innerHTML = '<h3>Transaction History</h3>';
        data.forEach(transaction => {
            transactionsDiv.innerHTML += `
                <p>${transaction.type}: ${transaction.quantity} units of ${transaction.stockSymbol} at $${transaction.pricePerUnit} each</p>
            `;
        });
    } catch (error) {
        console.error('Error fetching transactions data:', error);
    }
}

async function buyStock() {
    const symbol = document.getElementById('stockSymbol').value;
    const quantity = document.getElementById('quantity').value;
    const price = document.getElementById('price').value;

    try {
        const response = await fetch(`${API_BASE_URL}/trading/buy`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('jwt')}`
            },
            body: JSON.stringify({ symbol, quantity, price })
        });
        const data = await response.json();
        alert('Stock bought successfully!');
    } catch (error) {
        console.error('Error buying stock:', error);
    }
}

async function sellStock() {
    const symbol = document.getElementById('stockSymbol').value;
    const quantity = document.getElementById('quantity').value;
    const price = document.getElementById('price').value;

    try {
        const response = await fetch(`${API_BASE_URL}/trading/sell`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('jwt')}`
            },
            body: JSON.stringify({ symbol, quantity, price })
        });
        const data = await response.json();
        alert('Stock sold successfully!');
    } catch (error) {
        console.error('Error selling stock:', error);
    }
}

document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Prevent form submission

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch(`${API_BASE_URL}/signin`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        });
        const data = await response.json();

        if (data.status) {
            localStorage.setItem('jwt', data.jwt);
            alert('Login successful!');
            window.location.href = 'index.html'; // Redirect to homepage or dashboard
        } else {
            alert(data.message);
        }
    } catch (error) {
        console.error('Error logging in:', error);
    }
});