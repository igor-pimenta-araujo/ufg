<?php

namespace App\Http\Livewire;

use Livewire\Component;

class Calculator extends Component
{
    public $count = 0;
    public $result = 0;
    public $firstNumber = 0;
    public $secondNumber = 0;

    public function increment()
    {
        $this->count++;
    }

    public function sum()
    {
        $this->result = $this->firstNumber + $this->secondNumber;
    }

    public function minus()
    {
        $this->result = $this->firstNumber - $this->secondNumber;
    }

    public function division()
    {
        $this->result = $this->firstNumber / $this->secondNumber;
    }

    public function multiply()
    {
        $this->result = $this->firstNumber * $this->secondNumber;
    }

    public function render()
    {
        return view('livewire.counter');
    }
}
