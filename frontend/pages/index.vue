<script setup lang="ts">

const api = useRuntimeConfig().public.apiBase;

const fetchInfo = ref<string>("");
const showFetchInfo = ref<boolean>(true);
const flightData = ref<any>([]);

onMounted(() => {
    fetchFlights();
})

async function fetchFlights() {
    fetchInfo.value = "Laadin lende...";
    showFetchInfo.value = true;

    try {
        const response: any[] = await $fetch(`${api}/lennud`)
        if (response.length > 0) {
            flightData.value = response;
            showFetchInfo.value = false;
        } else {
            fetchInfo.value = "Ei leidnud ühtegi lendu.";
        }
    
    } catch (e) {
        console.info(e);
        fetchInfo.value = "Lendude laadimisel tekkis probleem. Proovige hiljem uuesti.";
    }
}

</script>

<template>

    <div class="flights-container">

        <div v-if="showFetchInfo">{{ fetchInfo }}</div>

        <div v-if="!showFetchInfo">
            <div v-for="flight in flightData">
                <span>{{ flight }}</span>
            </div>
        </div>

    </div>

</template>

<style scoped>

.flights-container {
    max-width: 40rem;
    margin: 20px auto;
    text-align: center;
}

.flight {
    background: #f4f4f4;
    margin: 5px 0;
    padding: 10px;
    border-radius: 5px;
}

</style>