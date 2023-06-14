<?php 

namespace App\Service;

use App\Models\User;
use App\Models\Post;

class GeneralService
{
    public static function all($entidade): array
    {
        if ($entidade == 'user') {
            return User::all()->toArray();
        }

        if ($entidade == 'post') {
            return Post::all()->toArray();
        }

        return [];
    }

    public static function create($entidade, $data)
    {
        if ($entidade == 'user') {
            return User::create($data);
        }

        if ($entidade == 'post') {
            return Post::create($data);
        }

        return false;
    }

}
