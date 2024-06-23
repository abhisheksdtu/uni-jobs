package com.project.unijobs.mapper;

import com.project.unijobs.dto.UserDTO;
import com.project.unijobs.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
