package com.rnit.Nabangga_na_ba.service;


import com.rnit.Nabangga_na_ba.dto.AccidentHistoryDto;
import com.rnit.Nabangga_na_ba.entity.AccidentHistory;
import com.rnit.Nabangga_na_ba.entity.Cars;
import com.rnit.Nabangga_na_ba.mapper.AccidentHistoryMapper;
import com.rnit.Nabangga_na_ba.repository.AccidentHistoryRepository;
import com.rnit.Nabangga_na_ba.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccidentHistoryService {

    private final AccidentHistoryRepository accidentHistoryRepository;
    private final CarRepository carRepository;

    public AccidentHistoryService(AccidentHistoryRepository accidentHistoryRepository, CarRepository carRepository) {
        this.accidentHistoryRepository = accidentHistoryRepository;
        this.carRepository = carRepository;
    }

    public List<AccidentHistoryDto> getAllAccidentHistories() {
        return accidentHistoryRepository.findAll()
                .stream()
                .map(AccidentHistoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<AccidentHistoryDto> getAccidentHistoryById(int id) {
        return accidentHistoryRepository.findById(id)
                .map(AccidentHistoryMapper::toDto);
    }

    public List<AccidentHistoryDto> getAccidentsByCarId(int carId) {
        return accidentHistoryRepository.findByCarId(carId)
                .stream()
                .map(AccidentHistoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<AccidentHistoryDto> addAccidentHistory(int carId, AccidentHistoryDto accidentDto) {
        Optional<Cars> carOptional = carRepository.findById(carId);
        if (carOptional.isEmpty()) {
            return Optional.empty();
        }

        Cars car = carOptional.get();
        AccidentHistory accident = AccidentHistoryMapper.toEntity(accidentDto, car);
        accident = accidentHistoryRepository.save(accident);
        return Optional.of(AccidentHistoryMapper.toDto(accident));
    }

    @Transactional
    public Optional<AccidentHistoryDto> updateAccidentHistory(int id, AccidentHistoryDto updatedAccidentDto) {
        return accidentHistoryRepository.findById(id).map(existingAccident -> {
            existingAccident.setAccidentDate(updatedAccidentDto.getAccidentDate());
            existingAccident.setLocation(updatedAccidentDto.getLocation());
            existingAccident.setDescription(updatedAccidentDto.getDescription());
            existingAccident.setDamageSeverity(updatedAccidentDto.getDamageSeverity());
            existingAccident.setRepairStatus(updatedAccidentDto.getRepairStatus());
            existingAccident.setReportedAt(updatedAccidentDto.getReportedAt());

            AccidentHistory savedAccident = accidentHistoryRepository.save(existingAccident);
            return AccidentHistoryMapper.toDto(savedAccident);
        });
    }

    @Transactional
    public boolean deleteAccidentHistory(int id) {
        if (accidentHistoryRepository.existsById(id)) {
            accidentHistoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
