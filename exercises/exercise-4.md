## Exercise 4: MongoDB Indexes

Index commands used:

db.courses.createIndex({ category: 1 })

db.courses.createIndex({ published: 1 })

db.courses.createIndex({ category: 1, published: 1 })

Indexes created:

* category index
* published index
* compound category + published index

Query pattern supported:

db.courses.find({ category: "Java" })

db.courses.find({ published: true })

db.courses.find({
category: "Java",
published: true
})

Why these indexes may help:

Indexes allow MongoDB to find matching documents more efficiently and reduce full collection scans.

Why category may need an index:

Applications often filter records by category. An index helps MongoDB quickly locate matching documents.

Why published may need an index:

Applications frequently show only published content. An index improves performance when filtering by publication status.

Why category + published may be useful together:

Many queries filter by both category and published status. A compound index can optimize these combined searches.

Why we should not index every field:

Indexes consume additional storage space and slow down insert, update, and delete operations because MongoDB must maintain every index.

Possible downside of too many indexes:

Too many indexes increase storage requirements and can negatively affect write performance.
