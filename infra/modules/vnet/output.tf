output "vnet_id" {
  value = azurerm_virtual_network.vnet.id
}

output "service_subnet_id" {
  value = azurerm_subnet.service.id
}

output "db_subnet_id" {
  value = azurerm_subnet.db.id
}

output "public_ip_address_id" {
  value = azurerm_public_ip.public.id
}