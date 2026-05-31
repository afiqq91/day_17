## Exercise 5: MongoDB Query Performance

Query tested:

{ "role": "USER" }

and

{ "email": "[test@plantation.com](mailto:test@plantation.com)" }

executionTimeMillis:

0 ms

totalDocsExamined:

3

totalKeysExamined:

0

Was an index used?

No. MongoDB performed a COLLSCAN (Collection Scan) and examined all documents in the collection.

What does this tell you?

The queries worked, but MongoDB had to scan every document because no suitable index was available. For a small collection this has little impact, but for large collections it can significantly slow down queries. Creating indexes on frequently searched fields such as email can improve query performance by reducing the number of documents MongoDB needs to examine.
