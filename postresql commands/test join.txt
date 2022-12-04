select r.id,ds."name", sa."name",sorta."name" from records r
left join data_structor_processes dsp on r.id = dsp.record_id 
left join data_structors ds on ds.id = dsp.data_structor_id
left join searching_processes sp on r.id = sp.record_id 
left join searching_algorithms sa on sp.searching_algorithm_id = sa.id
left join sorting_processes sortp on sortp.record_id  = r.id
left join sorting_algorithms sorta on sorta.id = sortp.sorting_algorithm_id
