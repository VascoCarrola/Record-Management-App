package vasco.recordManagementApp.service.impl;

import org.springframework.stereotype.Service;
import vasco.recordManagementApp.Repository.RecordRepository;
import vasco.recordManagementApp.model.Record;
import vasco.recordManagementApp.service.RecordService;

import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {
    private RecordRepository recordRepository;
    public RecordServiceImpl(RecordRepository recordRepository){
        super();
        this.recordRepository = recordRepository;
    }
    @Override
    public List<Record> getAllRecordsByUid(Long uid) {
        return recordRepository.findAllByUId(uid);
    }
    @Override
    public List<Record> getAllRecordsByArtist(Long uid, String artist) {
        return recordRepository.findAllByArtist(uid,artist);
    }
    @Override
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }
    @Override
    public Record getRecordById(Long id) {
        return recordRepository.getReferenceById(id);
    }
    @Override
    public Record updateRecord(Record record) {
        return recordRepository.save(record);
    }
    @Override
    public void deleteRecordById(Long id) {
        recordRepository.deleteById(id);
    }
}
