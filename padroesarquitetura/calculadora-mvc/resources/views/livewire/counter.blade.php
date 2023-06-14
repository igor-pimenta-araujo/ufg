<div>
    <div class="" style="text-align: center">
        <h1 class="text-3xl font-bold">Calculator</h1>
        <input type="text" wire:model="firstNumber" class="border-2 border-gray-300 p-2 rounded-lg">
        <input type="text" wire:model="secondNumber" class="border-2 border-gray-300 p-2 rounded-lg mb-6">
        <br>
        <button wire:click="sum" class="border-2 border-gray-300 p-2 rounded-lg text-lg ">+</button>
        <button wire:click="minus" class="border-2 border-gray-300 p-2 rounded-lg text-lg">-</button>
        <button wire:click="division" class="border-2 border-gray-300 p-2 rounded-lg text-lg">/</button>
        <button wire:click="multiply" class="border-2 border-gray-300 p-2 rounded-lg text-lg">*</button>
        <br>
        <p>
            Result: {{ $result }}
        </p>
    </div>
</div>