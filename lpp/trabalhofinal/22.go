package main

type BankAccount struct {
    balance float64
    owner string
}

func (b *BankAccount) Deposit(amount float64) {
    b.balance += amount
}

func (b *BankAccount) Withdraw(amount float64) {
    b.balance -= amount
}

func (b BankAccount) Balance() float64 {
    return b.balance
}

func main() {
    account := BankAccount{
        balance: 0,
        owner: "John Doe",
    }
    account.Deposit(100)
    println(account.Balance())
}
