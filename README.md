# Credit card fraud detection service.

Credit card fraud detection service is a service that has 1 endpoint takes in several parameters as inputs, calls another service to get
information regarding the transaction, and then applies some business logic before returning a decision to approve
or decline the transaction.

## Business Requirements:

The following fraud scenarios need to be implemented
in this proof of concept service that we’re building.
- If the amount of a transaction is over $50,000.00 decline the transaction.
- If the card has been used over 60 times in the last 7 days, decline the transaction.
- If the card has been used under 35 times in the last 7 days, decline the transaction if the (transaction
  amount/times used in last 7 days) > 500. (E.g. Decline if transaction amount is $9000 and the card has
  been used 2 times in the last 7 days. 9000/2 = 4500)
- Approve all other transactions.

## External Service Call:

We have a external microservice that
returns how many times a card has been used in each of 
the past 7 days. This service can be called using the following endpoint:.

https://www.random.org/integers/?num=7&min=0&max=12&col=1&base=10&format=plain&rnd=new

Example response where the card was used 4,6,10,12,1,12,and 2 times for a total of 47 times in the past 7 days: [4,
6, 10, 12, 1, 12, 2]

## Request JSON object:
```bash
{
"transaction": {
"cardNum":5206840000000001,
"amount":3.99
}
}
```

## Response JSON object:

```python
{
    "status": true,
    "cardNumber": 5206840000000001,
    "transactionAmount": 3.99,
    "cardUsageCount": 51
}
