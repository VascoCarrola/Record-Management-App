package vasco.recordManagementApp.service;

import vasco.recordManagementApp.model.Record;

import java.util.List;

public interface RecordService {
    List<Record> getAllRecordsByUid(Long uid);
    List<Record> getAllRecordsByArtist(Long uid, String artist);
    Record saveRecord(Record record);
    Record getRecordById(Long id);
    Record updateRecord(Record record);
    void deleteRecordById(Long id);
}
