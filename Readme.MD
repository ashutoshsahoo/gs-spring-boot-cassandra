
# Spring Boot + Apache Cassandra

- Start a Cassandra instance using [Docker Compose](https://github.com/bitnami/containers/blob/main/bitnami/cassandra/docker-compose-cluster.yml):

```bash
$ docker compose up -d
```
- Open Cassandra CQL Shell:

```bash
$ docker compose exec -it cassandra-node1 /bin/bash
$ cqlsh -u cassandra -p password123
```

- Create Cassandra keyspace with name `customer_ks`:

```cql
cqlsh> CREATE KEYSPACE customer_ks WITH replication={'class':'SimpleStrategy', 'replication_factor':1};
```
- Create `customer` table in `customer_ks` keyspace:

```cql
cqlsh> USE customer_ks;
cqlsh:customer_ks> CREATE TABLE customer(id int PRIMARY KEY,firstname text,lastname text,age int);
```

- Create an index on `firstname` column:

```cql
cqlsh:customer_ks> CREATE INDEX ON customer_ks.customer (firstname);
```

- Verify and  Query `customer` table:

```cql
cqlsh:customer_ks> DESCRIBE TABLE customer;
cqlsh:customer_ks> SELECT * FROM customer;
```

- Run the application:
```bash
$ gradle bootRun
```