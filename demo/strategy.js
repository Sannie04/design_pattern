class PaymentStrategy {
    pay(amount) {
        throw "This method should be overridden!";
    }
}

class CreditCardPayment extends PaymentStrategy {
    pay(amount) {
        console.log("Paid " + amount + " using Credit Card");
    }
}

class PayPalPayment extends PaymentStrategy {
    pay(amount) {
        console.log("Paid " + amount + " using PayPal");
    }
}

class PaymentContext {
    constructor(strategy) {
        this.strategy = strategy;
    }

    executePayment(amount) {
        this.strategy.pay(amount);
    }
}

const creditCardPayment = new CreditCardPayment();
const payPalPayment = new PayPalPayment();

let context = new PaymentContext(creditCardPayment);
context.executePayment(100); // Paid 100 using Credit Card

context = new PaymentContext(payPalPayment);
context.executePayment(200); // Paid 200 using PayPal
