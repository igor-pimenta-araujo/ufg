<?php

namespace App\Http\Livewire;

use Livewire\Component;

class ShowCalculator extends Component
{
    public $firstNumber = 2;
    public $secondNumber = 5;
    public $result = 0;

    public function sum() : void
    {
        $this->result = $this->firstNumber + $this->secondNumber;
    }
    
    public function render(): \Illuminate\View\View
    {
        return view('livewire.show-calculator');
    }
}
