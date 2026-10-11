terraform {
    backend "azurerm" {}
}

resource "azurerm_resource_group" "rg" {
    name        = "${var.prefix}-rg"
    location    = var.location
}

module "vnet" {
    source              = "./modules/vnet"

    prefix              = var.prefix
    resource_group_name = azurerm_resource_group.rg.name
    location            = azurerm_resource_group.rg.location
    local_ip            = var.local_ip
}

module "wayout" {
    source              = "./modules/wayout"

    prefix              = var.prefix
    resource_group_name = azurerm_resource_group.rg.name
    location            = azurerm_resource_group.rg.location
    service_subnet_id   = module.vnet.service_subnet_id
}

module "db" {
    source = "./modules/db"

    db_login            = var.db_login
    db_password         = var.db_password
    location            = azurerm_resource_group.rg.location
    prefix              = var.prefix
    db_subnet_id        = module.vnet.db_subnet_id
    resource_group_name = azurerm_resource_group.rg.name
    vnet_id             = module.vnet.vnet_id
}

module "service" {
    source               = "./modules/service"

    admin_ssh_key        = var.admin_ssh_key
    admin_username       = var.admin_username
    beacon_image         = var.beacon_image
    db_login             = var.db_login
    db_name              = var.db_name
    db_password          = var.db_password
    location             = azurerm_resource_group.rg.location
    prefix               = var.prefix
    db_fqdn              = module.db.db_fqdn
    public_ip_address_id = module.vnet.public_ip_address_id
    resource_group_name  = azurerm_resource_group.rg.name
    service_subnet_id    = module.vnet.service_subnet_id
    nginx_conf_file      = "${path.root}/../nginx.conf"
}