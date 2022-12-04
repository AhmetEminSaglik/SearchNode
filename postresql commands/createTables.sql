CREATE TABLE records(
id SERIAL PRIMARY KEY
);

CREATE TABLE data_structors(
id SERIAL PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL	
);

CREATE TABLE sorting_algorithms(
id SERIAL PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL	
);

CREATE TABLE searching_algorithms(
id SERIAL PRIMARY KEY,
name VARCHAR(50) UNIQUE NOT NULL	
);

CREATE TABLE data_structor_processes(
id SERIAL PRIMARY KEY,
record_id INTEGER NOT NULL,
data_structor_id INTEGER NOT NULL
);

CREATE TABLE sorting_processes(
id SERIAL PRIMARY KEY,
record_id INTEGER NOT NULL,
sorting_algorithm_id INTEGER NOT NULL
);

CREATE TABLE searching_processes(
id SERIAL PRIMARY KEY,
record_id INTEGER NOT NULL,
searching_algorithm_id INTEGER NOT NULL
);

CREATE TABLE process_names(
id SERIAL PRIMARY KEY,
name VARCHAR(50) NOT NULL
);


CREATE TABLE word_lists(
id SERIAL PRIMARY KEY,
word_tbl_name VARCHAR(50) NOT NULL
);

CREATE TABLE word_processes(
id SERIAL PRIMARY KEY,
record_id INTEGER NOT NULL,
total_word_list_id INTEGER NOT NULL,
searched_word_list_id INTEGER NOT NULL,
found_word INTEGER NOT NULL,
missing_word INTEGER NOT NULL
);

CREATE TABLE complexity(
id SERIAL PRIMARY KEY,
record_id INTEGER NOT NULL,
process_name_id INTEGER NOT NULL,
process_name_record_id INTEGER NOT NULL,
elapsed_time TIME NOT NULL,
memory_usage VARCHAR(50) NOT NULL
);

INSERT INTO records(id)
VALUES(DEFAULT);

INSERT INTO data_structors(name)
VALUES('SearchNode'),('ArrayList');


INSERT INTO sorting_algorithms(name)
VALUES('SearchNode'),('QuickSort'),('IntroSort'),('TimSort'),
('MergeSort'),('HeapSort'),('InsertionSort'),('BubbleSort'),('SelectionSort');

INSERT INTO searching_algorithms(name)
VALUES('SearchNode'),('BinarySearch'),('LinearSearch');


INSERT INTO data_structor_processes(record_id, data_structor_id)
VALUES(1,2);

INSERT INTO sorting_processes(record_id, sorting_algorithm_id)
VALUES(1,5);

INSERT INTO searching_processes(record_id, searching_algorithm_id)
VALUES(1,2);

INSERT INTO process_names(name)
VALUES('data_structor_processes'),('sorting_processes'),
('searching_processes');

CREATE TABLE words_10(
id SERIAL PRIMARY KEY,
word VARCHAR(50) NOT NULL
);

CREATE TABLE words_3(
id SERIAL PRIMARY KEY,
word VARCHAR(50) NOT NULL
);

INSERT INTO words_10(word)
VALUES('table'),('desk'),('swim'),('pool'),('water'),
('tree'),('hunter'),('movie'),('wednesday'),('Stranger');

INSERT INTO words_3(word)
VALUES('table'),('water'),('Stranger');

INSERT INTO word_lists(word_tbl_name)
VALUES('words_10'),('words_3');

INSERT INTO word_processes(record_id, total_word_list_id,
searched_word_list_id,found_word,missing_word)
VALUES(1,1,1,3,0);

INSERT INTO complexity(record_id, process_name_id,
process_name_record_id,elapsed_time,memory_usage)
VALUES(1,3,1,'00:01:44','1024 kb'); 
