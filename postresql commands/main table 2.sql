select
record.id as "Record",
pn_ds.name as "test",
ds."name" as "Data Structor",
comp_ds.elapsed_time as "Elapsed Time DS",
comp_ds.memory_usage as "Memory Usage DS",
sorta."name" as "Sorting Algorithm",
comp_sort.elapsed_time as "Elapsed Time Sorting ",
comp_sort.memory_usage as "Memory Usage Sorting",
searchalgo."name" as "Searching Algorithm",
comp_search.elapsed_time as "Searching Procces Elapsed Time",
comp_search.memory_usage as "Memory Usage Search",
total_world_list.word_tbl_name as "Total World List Name",
searched_world_list.word_tbl_name as "Searched World List Name",
wp.found_word as "Found Word",
wp.missing_word as "Missing word"


from records record
inner join data_structor_processes dsp on record.id = dsp.record_id
left join process_names pn_ds on pn_ds.name like data_structor_process  -- varchar equality
left join data_structors ds on ds.id = dsp.data_structor_id
left join sorting_processes sortp on sortp.record_id  = record.id
left join sorting_algorithms sorta on sorta.id = sortp.sorting_algorithm_id
right join searching_processes searchp on record.id = searchp.record_id 
left join searching_algorithms searchalgo on searchp.searching_algorithm_id = searchalgo.id
left  join word_processes wp on wp.record_id = record.id
left join word_lists total_world_list on total_world_list.id = wp.total_word_list_id
left join word_lists searched_world_list on searched_world_list.id = wp.searched_word_list_id
left join complexity comp_ds on comp_ds.record_id=record.id and comp_ds.process_name_id=1 
left join complexity comp_sort on comp_sort.record_id=record.id and comp_sort.process_name_id=2
left join complexity comp_search on comp_search.record_id=record.id and comp_search.process_name_id=3
