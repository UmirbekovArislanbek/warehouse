package qr.data.warehousespring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.UserDto;
import qr.data.warehousespring.entity.User;
import qr.data.warehousespring.entity.Warehouse;
import qr.data.warehousespring.repasitory.UserRepasitory;
import qr.data.warehousespring.repasitory.WarehouseRepasitory;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    UserRepasitory userRepository;
    WarehouseRepasitory warehouseRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    public Result add(UserDto userDto) {
        List<Integer> warehousesId = userDto.getWarehousesId();
        Set<Warehouse> warehouses = new HashSet<>();
        for (Integer integer : warehousesId) {
            Optional<Warehouse> byId = warehouseRepository.findById(integer);
            if (byId.isEmpty()) {
                return new Result("Warehouse not found", false);
            }
            warehouses.add(byId.get());
        }
        if (!checkByPhoneNumberOrCode(userDto)
                .isStatus()) {
            return checkByPhoneNumberOrCode(userDto);
        }
        User user = new User();
        user.setWarehouses(warehouses);
        return setData(user, userDto);
    }

    private Result checkByPhoneNumberOrCode(UserDto userDto) {
        boolean b1 = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        boolean b2 = userRepository.existsByCode(userDto.getCode());
        if (b1) {
            return new Result("This phone number already exist", false);
        }
        if (b2) {
            return new Result("This code already exist", false);
        }
        return new Result("All right", true);
    }

    public Result update(UserDto userDto, Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return new Result("User not found", false);
        }
        List<Integer> warehousesId = userDto.getWarehousesId();
        Set<Warehouse> warehouses = new HashSet<>();
        for (Integer integer : warehousesId) {
            Optional<Warehouse> whbyId = warehouseRepository.findById(integer);
            if (whbyId.isEmpty()) {
                return new Result("Warehouse not found", false);
            }
            warehouses.add(whbyId.get());
        }
        if (!checkByPhoneNumberOrCode(userDto).isStatus()) {
            return checkByPhoneNumberOrCode(userDto);
        }
        User user = byId.get();
        user.setWarehouses(warehouses);
        return setData(user, userDto);
    }

    private Result setData(User user, UserDto userDto) {
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setCode(userDto.getCode());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setStatus(userDto.isStatus());
        userRepository.save(user);
        return new Result("Successfull saved", true);
    }

    public Result deleteById(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return new Result("User not found", false);
        }
        userRepository.deleteById(id);
        return new Result("Successfull deleted", true);
    }
}
