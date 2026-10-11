variable "subscription_id" {
    type        = string
    sensitive   = true
}

variable "prefix" {
    type = string
}

variable "location" {
    type = string
}

variable "db_login" {
    type        = string
    sensitive   = true
}

variable "db_password" {
    type        = string
    sensitive   = true
}

variable "beacon_image" {
    type = string
}

variable "admin_ssh_key" {
    type = string
}

variable "admin_username" {
    type        = string
    sensitive   = true
}

variable "db_name" {
    type = string
}

variable "local_ip" {
    type = string
}

variable "locked" {
    type    = bool
    default = false
}