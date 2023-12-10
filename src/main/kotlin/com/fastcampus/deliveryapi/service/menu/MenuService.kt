package com.fastcampus.deliveryapi.service.menu

import com.fastcampus.deliveryapi.repository.menu.Menu
import com.fastcampus.deliveryapi.repository.menu.MenuRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MenuService(
    private val menuRepository: MenuRepository
) {
    fun findByStoreId(storeId: Long): List<Menu> {
        return menuRepository.findAllByStoreId(storeId)
    }

    fun findByMenuId(menuId: Long): Optional<Menu> {
        return menuRepository.findById(menuId)
    }
}