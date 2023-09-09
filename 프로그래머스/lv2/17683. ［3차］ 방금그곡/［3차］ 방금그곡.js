function solution(m, musicinfos) {
    const sound = m.replace(/(\w)#/g, (_, note) => note.toLowerCase());
    const candidates = [];

    musicinfos.forEach((el, idx) => {
        const [startTime, endTime, title, melody] = el.split(",");
        const [startHour, startMinute] = startTime.split(":").map(Number);
        const [endHour, endMinute] = endTime.split(":").map(Number);
        const duration = (endHour - startHour) * 60 + (endMinute - startMinute);

        const playedMelody = melody.replace(/(\w)#/g, (_, note) => note.toLowerCase());

        let fullMelody = playedMelody.repeat(Math.floor(duration / playedMelody.length));
        const remainder = duration % playedMelody.length;
        fullMelody += playedMelody.slice(0, remainder);

        if (fullMelody.includes(sound)) {
            candidates.push({ title, time: duration });
        }
    });

    if (candidates.length === 0) {
        return "(None)";
    }

    candidates.sort((a, b) => b.time - a.time || musicinfos.indexOf(a.title) - musicinfos.indexOf(b.title));

    return candidates[0].title;
}