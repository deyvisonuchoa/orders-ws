# web service de ordem de serviço udemy

Ws em produção
https://course-javasb-orders-ws.herokuapp.com/

Endpoints

GET
/users  ->  list all
/users/{id}  ->  find by id

/categories  ->  list all
/categories/{id}  ->  find by id

/products  ->  list all
/products/{id}  ->  find by id

/orders  ->  list all
/orders/{id}  ->  find by id

POST
/users  ->  JSON {name: valor, email: valor, phone: valor, password: valor}

/categories  ->  JSON {name: valor}

DELETE
/users/{id}  ->  Delete by id

/categories/{id}  ->  Delete by id

PUT
/users/{id}  ->  Update by id  ->  JSON {name: valor, email: valor, phone: valor}

/categories/{id}  ->  Update by id  ->  JSON {name: valor}
