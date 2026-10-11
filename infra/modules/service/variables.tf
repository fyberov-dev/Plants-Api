variable "prefix" {
  type = string
}

variable "resource_group_name" {
  type = string
}

variable "location" {
  type = string
}

variable "service_subnet_id" {
  type = string
}

variable "public_ip_address_id" {
  type = string
}

variable "vm_size" {
  type    = string
  default = "Standard_B2ats_v2"
}

variable "admin_username" {
  type = string
}

variable "admin_ssh_key" {
  type = string
}

variable "beacon_image" {
  type = string
}

variable "db_login" {
  type = string
}

variable "db_password" {
  type = string
}

variable "db_name" {
  type = string
}

variable "db_fqdn" {
  type = string
}

variable "nginx_conf_file" {
  type = string
}