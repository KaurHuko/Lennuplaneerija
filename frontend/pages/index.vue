<script setup lang="ts">

const api = useRuntimeConfig().public.apiBase;

const fetchInfo = ref<string>("");
const showFetchInfo = ref<boolean>(true);
const flightData = ref<any>([]);

function formatTime(isoString: string) {
    const date = new Date(isoString);
    return date.toLocaleTimeString([], { hour: "2-digit", minute: "2-digit" });
}

function formatDuration(minutes: number) {
    return Math.floor(minutes / 60) + "h " + ((minutes % 60 != 0) ? minutes % 60 + "m" : "");
}

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
            <div class="flight" v-for="flight in flightData">

                <div class="departure">
                    <span class="time">{{ formatTime(flight.valjumisAeg) }}</span>
                    <br>
                    <span>{{ flight.valjumisKoht }}</span>
                </div>

                <div class="duration">
                    <p>{{ formatDuration(flight.lennuaegMinutid) }}</p>
                </div>

                <div class="arrival">
                    <span class="time">{{ formatTime(flight.saabumisAeg) }}</span>
                    <br>
                    <span>{{ flight.saabumisKoht }}</span>
                </div>

                <div class="price">
                    <p>{{ flight.hindEur }}€</p>
                </div>

            </div>
        </div>
    </div>

</template>

<style scoped>

.flights-container {
    max-width: 40rem;
    margin: 2rem auto;
    text-align: center;
}

.flight {
    background: #eeeeee;
    margin: 1rem 0;
    padding: 0.1rem;
    border-radius: 2rem;

    display: grid;
    grid-template-columns: 1fr 1fr 1fr auto;
    align-items: center;
}

.time {
    font-size: 2rem;
}

.price {
    margin: 0rem 2rem;
    font-size: 1.5rem;
}


</style>