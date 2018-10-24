
**Rest API for transfer money**
Simple standalone application with HTTP REST API for transferring money between account with embedded database

For to start 
1. "git clone https://github.com/OlegAryukov/moneytransfer.git" .

2. In project folder run mvn clean install to compile application and run tests

3. Go to "target" folder and run in terminal "java -jar moneytransfer-1.0-SNAPSHOT.jar" Application will start and create in-memory database.

You can go to http://localhost:8082 in web and connect to "jdbc:h2:mem:dbtest" NO user and NO pass.

API All calls to API must be started with http://localhost:4567/

|Endpoint| Description | Parameters |Success Response	|
|--|--|--|--|
|POST /user | Creates new User | Request param { "name":"Mike", "secondName":"Manson" } |	 |
|POST /account| Creates new account for User|Request param { "currType":"USD", "amount":200.5, "userId":"3" }|
|GET /account/{id}| Gets account by ID Path: id - account ID |	 |{ "id": 1, "amount": 100.1, "currencyType": "USD", "user": { "id": 1, "name": "Bob", "secondName": "Jhonse", "bankAccounts": [{ "amount": 100.1, "currencyType": "USD" }], } }|
|POST /account/transfer|Trnasfer money|{"bankAccIdSource":"1","bankAccIdDest":"2","sum":10}|{"message": "Transfer SUCCESS"}|
|POST /account/transferex|Trnasfer money with exchange|{"bankAccIdSource":"1","bankAccIdDest":"2","sum":10, "exchangeCourse":1.25}|{"message": "Transfer SUCCESS"}|
|GET /history|Get transfer history||
