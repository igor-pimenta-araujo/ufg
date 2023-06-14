<?php 

namespace App\Service;

use App\Models\User;

class UserService
{
    public static function all(): array
    {
        return User::all()->toArray();
    }
    
    public static function create(array $data): User
    {
        return User::create($data);
    }
}
